import request from '@/utils/request'

// 查询产品型号维护列表
export function listProduct_category(query) {
  return request({
    url: '/system/product_category/list',
    method: 'get',
    params: query
  })
}

// 查询产品型号维护详细
export function getProduct_category(productId) {
  return request({
    url: '/system/product_category/' + productId,
    method: 'get'
  })
}

// 新增产品型号维护
export function addProduct_category(data) {
  return request({
    url: '/system/product_category',
    method: 'post',
    data: data
  })
}

// 修改产品型号维护
export function updateProduct_category(data) {
  return request({
    url: '/system/product_category',
    method: 'put',
    data: data
  })
}

// 删除产品型号维护
export function delProduct_category(productId) {
  return request({
    url: '/system/product_category/' + productId,
    method: 'delete'
  })
}
