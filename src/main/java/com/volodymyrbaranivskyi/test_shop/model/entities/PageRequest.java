package com.volodymyrbaranivskyi.test_shop.model.entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;

@Data
@Slf4j
public class PageRequest {

    private int page;
    private int size;

    private PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public static PageRequest createPageRequest(Integer page, Integer size) {
        if ((isNull(page) || isNull(size))) {
            String message = "Page and size are obligatory fields for pagination!";
            log.warn(message);
        }

        if (isNull(page) || isNull(size)) {
            return null;
        }

        if (page < 1) {
            String message = "Page index must be greater than zero!";
            log.warn(message);
        }
        if (size < 1) {
            String message = "Page size must be greater than zero!";
            log.warn(message);
        }
        return new PageRequest(page - 1, size);
    }

    public int getOffset() {
        return this.page * this.size;
    }
}
