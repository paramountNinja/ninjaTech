package jvm;

import com.ninja.dto.SchoolInfo;
import com.ninja.dto.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试加载顺序
 *
 * @Desc
 * @Author ninja
 * @Date Created on 2023/10/25
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("ninja");
        userInfo.setSchoolInfos(fetchSchools());

        System.out.println(userInfo);

    }

    private static List<SchoolInfo> fetchSchools() {
        List<SchoolInfo> schoolInfos = new ArrayList<>();
        SchoolInfo schoolInfo = new SchoolInfo();
        schoolInfo.setAddress("上海");
        schoolInfo.setAge("100");
        schoolInfo.setName("DHU");
        schoolInfos.add(schoolInfo);
        return schoolInfos;
    }


}
