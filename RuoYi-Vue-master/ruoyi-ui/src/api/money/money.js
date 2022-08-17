import request from '@/utils/request'

// 查询资金信息列表
export function listMoney(query) {
  return request({
    url: '/money/money/list',
    method: 'get',
    params: query
  })
}

// 查询资金信息详细
export function getMoney(moneyId) {
  return request({
    url: '/money/money/' + moneyId,
    method: 'get'
  })
}

// 新增资金信息
export function addMoney(data) {
  return request({
    url: '/money/money',
    method: 'post',
    data: data
  })
}

// 修改资金信息
export function updateMoney(data) {
  return request({
    url: '/money/money',
    method: 'put',
    data: data
  })
}

// 删除资金信息
export function delMoney(moneyId) {
  return request({
    url: '/money/money/' + moneyId,
    method: 'delete'
  })
}
