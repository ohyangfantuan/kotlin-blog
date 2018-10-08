package com.oywy.common

/**
 * Created by oywy on 2018/4/16.
 */
data class ApiResult(
        val data: Any?,
        val code: Int,
        val message: String
) {
    companion object {
        fun ok() = ApiResult(null, ApiResultCode.OK.code, ApiResultCode.OK.msg)
        fun ok(data: Any?) = ApiResult(data, ApiResultCode.OK.code, ApiResultCode.OK.msg)
        fun notFound() = ApiResult(null, ApiResultCode.NOT_FOUND.code, ApiResultCode.NOT_FOUND.msg)
        fun of(apiResultCode: ApiResultCode) = ApiResult(null, apiResultCode.code, apiResultCode.msg)
    }
}