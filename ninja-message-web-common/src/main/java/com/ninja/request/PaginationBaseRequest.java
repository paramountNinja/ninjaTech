package com.ninja.request;

import lombok.Data;

/**
 * Created by z675568 on 2019/4/20.
 */
@Data
public class PaginationBaseRequest extends BaseRequest{
    private int pageIndex = 1;
    private int pageSize = 10;

    public int getOffset(){
        return (pageIndex - 1) * pageSize;
    }
}
