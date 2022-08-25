-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品类别维护', '2093', '1', 'product', 'system/product/index', 1, 0, 'C', '0', '0', 'system:product:list', '#', 'admin', sysdate(), '', null, '产品类别维护菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品类别维护查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:product:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品类别维护新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:product:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品类别维护修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:product:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品类别维护删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:product:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品类别维护导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:product:export',       '#', 'admin', sysdate(), '', null, '');