package com.taipeizooplants.model;

import androidx.paging.PagedList;

public interface PageConfigParams {

    int PAGE_SIZE = 5;

    int INITIAL_LOAD_KEY = 0;

    PagedList.Config CONFIG = new PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build();
}
