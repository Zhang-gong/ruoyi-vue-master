import request from '@/utils/request'

// 查询颜色维护列表
export function listProduct_color(query) {
  return request({
    url: '/system/product_color/list',
    method: 'get',
    params: query
  })
}

// 查询颜色维护详细
export function getProduct_color(productId) {
  return request({
    url: '/system/product_color/' + productId,
    method: 'get'
  })
}

// 新增颜色维护
export function addProduct_color(data) {
  return request({
    url: '/system/product_color',
    method: 'post',
    data: data
  })
}

// 修改颜色维护
export function updateProduct_color(data) {
  return request({
    url: '/system/product_color',
    method: 'put',
    data: data
  })
}

// 删除颜色维护
export function delProduct_color(productId) {
  return request({
    url: '/system/product_color/' + productId,
    method: 'delete'
  })
}
