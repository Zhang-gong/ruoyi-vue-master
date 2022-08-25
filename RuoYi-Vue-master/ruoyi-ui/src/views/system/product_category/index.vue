<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="产品型号" prop="productModel">
        <el-input
          v-model="queryParams.productModel"
          placeholder="请输入产品型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品类别" prop="productCategory">
        <el-input
          v-model="queryParams.productCategory"
          placeholder="请输入产品类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="productComment">
        <el-input
          v-model="queryParams.productComment"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后修改日期">
        <el-date-picker
          v-model="daterangeProductLastDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="最后修改时间">
        <el-date-picker
          v-model="daterangeProductLastTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="最后修改人" prop="productLastName">
        <el-input
          v-model="queryParams.productLastName"
          placeholder="请输入最后修改人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后修改tcode" prop="productLastTcode">
        <el-input
          v-model="queryParams.productLastTcode"
          placeholder="请输入最后修改tcode"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="终端" prop="productTerminal">
        <el-input
          v-model="queryParams.productTerminal"
          placeholder="请输入终端"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="ip地址" prop="productIp">
        <el-input
          v-model="queryParams.productIp"
          placeholder="请输入ip地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:product_category:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:product_category:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:product_category:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:product_category:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="product_categoryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="产品编号" align="center" prop="productId" />
      <el-table-column label="产品型号" align="center" prop="productModel" />
      <el-table-column label="产品类别" align="center" prop="productCategory" />
      <el-table-column label="备注" align="center" prop="productComment" />
      <el-table-column label="最后修改日期" align="center" prop="productLastDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.productLastDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后修改时间" align="center" prop="productLastTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.productLastTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后修改人" align="center" prop="productLastName" />
      <el-table-column label="最后修改tcode" align="center" prop="productLastTcode" />
      <el-table-column label="终端" align="center" prop="productTerminal" />
      <el-table-column label="ip地址" align="center" prop="productIp" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:product_category:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:product_category:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改产品型号维护对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="产品型号" prop="productModel">
          <el-input v-model="form.productModel" placeholder="请输入产品型号" />
        </el-form-item>
        <el-form-item label="产品类别" prop="productCategory">
          <el-input v-model="form.productCategory" placeholder="请输入产品类别" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProduct_category, getProduct_category, delProduct_category, addProduct_category, updateProduct_category } from "@/api/system/product_category";

export default {
  name: "Product_category",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 产品型号维护表格数据
      product_categoryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 产品类别时间范围
      daterangeProductLastDate: [],
      // 产品类别时间范围
      daterangeProductLastTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productModel: null,
        productCategory: null,
        productComment: null,
        productLastDate: null,
        productLastTime: null,
        productLastName: null,
        productLastTcode: null,
        productTerminal: null,
        productIp: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询产品型号维护列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeProductLastDate && '' != this.daterangeProductLastDate) {
        this.queryParams.params["beginProductLastDate"] = this.daterangeProductLastDate[0];
        this.queryParams.params["endProductLastDate"] = this.daterangeProductLastDate[1];
      }
      if (null != this.daterangeProductLastTime && '' != this.daterangeProductLastTime) {
        this.queryParams.params["beginProductLastTime"] = this.daterangeProductLastTime[0];
        this.queryParams.params["endProductLastTime"] = this.daterangeProductLastTime[1];
      }
      listProduct_category(this.queryParams).then(response => {
        this.product_categoryList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        productId: null,
        productModel: null,
        productCategory: null,
        productComment: null,
        productLastDate: null,
        productLastTime: null,
        productLastName: null,
        productLastTcode: null,
        productTerminal: null,
        productIp: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeProductLastDate = [];
      this.daterangeProductLastTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.productId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加产品型号维护";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const productId = row.productId || this.ids
      getProduct_category(productId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改产品型号维护";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.productId != null) {
            updateProduct_category(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProduct_category(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const productIds = row.productId || this.ids;
      this.$modal.confirm('是否确认删除产品型号维护编号为"' + productIds + '"的数据项？').then(function() {
        return delProduct_category(productIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/product_category/export', {
        ...this.queryParams
      }, `product_category_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
