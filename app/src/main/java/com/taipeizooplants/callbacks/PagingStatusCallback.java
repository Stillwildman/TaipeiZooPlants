package com.taipeizooplants.callbacks;

public interface PagingStatusCallback {

    void onLoading(boolean isInLoading);

    void onFailed(String errorMessage);
}
