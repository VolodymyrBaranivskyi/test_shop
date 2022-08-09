package com.volodymyrbaranivskyi.test_shop.Util;

import lombok.Data;

@Data
public class ResponseInfo {

    public ResponseInfo(int page) {
        this.page = page;
    }

    private int page;
    private int numPages;
    private int itemsPerPage;
    private int totalItems;
}
