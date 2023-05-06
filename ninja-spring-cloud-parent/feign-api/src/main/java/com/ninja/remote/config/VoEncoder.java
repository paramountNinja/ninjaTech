package com.ninja.remote.config;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.val;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/4/25
 */
public class VoEncoder extends SpringFormEncoder {

    private final Encoder defaultEncoder;

    public VoEncoder(SpringEncoder springEncoder) {
        this.defaultEncoder = springEncoder;
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        String contentType = getContentTypeValue(template.headers());
        if (StringUtils.isEmpty(contentType)) {
            defaultEncoder.encode(object, bodyType, template);
        }
        boolean isFormRequest = MediaType.MULTIPART_FORM_DATA_VALUE.equalsIgnoreCase(contentType) ||
                MediaType.APPLICATION_FORM_URLENCODED_VALUE.equalsIgnoreCase(contentType);
        if (!isFormRequest) {
            defaultEncoder.encode(object, bodyType, template);
            return;
        }

        boolean canUseOriginFormEncoder = isFormRequest && Map.class.isAssignableFrom((Class<?>) bodyType);
        if (canUseOriginFormEncoder) {
            super.encode(object, bodyType, template);
            return;
        }

        Map<String, Object> data = new HashMap<>(4);
        Map<String, Object> propertyMap = null;
        try {
            propertyMap = PropertyUtils.describe(object);
            Iterator<String> iterator = propertyMap.keySet().iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                //只保留value不为空的
                if (propertyMap.get(next) == null) {
                    iterator.remove();
                }
            }
            propertyMap.remove("class");
            data.putAll(propertyMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        super.encode(object, bodyType, template);
    }


    private String getContentTypeValue(Map<String, Collection<String>> headers) {
        for (val entry : headers.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Type")) {
                continue;
            }
            for (val contentTypeValue : entry.getValue()) {
                if (contentTypeValue == null) {
                    continue;
                }
                return contentTypeValue;
            }
        }
        return null;
    }
}
