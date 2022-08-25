-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('颜色维护', '2093', '1', 'product_color', 'system/product_color/index', 1, 0, 'C', '0', '0', 'system:product_color:list', '#', 'admin', sysdate(), '', null, '颜色维护菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('颜色维护查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:product_color:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('颜色维护新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:product_color:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('颜色维护修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:product_color:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('颜色维护删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:product_color:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('颜色维护导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:product_color:export',       '#', 'admin', sysdate(), '', null, '');