<template>
  <div>
    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-col :span="12">
          <el-form-item label="姓名" prop="x">
            <el-input v-model="formData.x" placeholder="aaama" clearable :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="手机号" prop="mobile">
            <el-input v-model="formData.mobile" placeholder="请输入手机号" :maxlength="11" show-word-limit clearable
              prefix-icon='el-icon-mobile' :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="单行文本" prop="field102">
            <el-input v-model="formData.field102" placeholder="请输入单行文本" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="密码" prop="field103">
            <el-input v-model="formData.field103" placeholder="请输入密码" clearable show-password
              :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="计数器" prop="field104">
            <el-input-number v-model="formData.field104" placeholder="计数器"></el-input-number>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="下拉选择" prop="field105">
            <el-select v-model="formData.field105" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field105Options" :key="index" :label="item.label"
                :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="级联选择" prop="field106">
            <el-cascader v-model="formData.field106" :options="field106Options" :props="field106Props"
              :style="{width: '100%'}" placeholder="请选择级联选择" clearable></el-cascader>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="滑块" prop="field107" required>
            <el-slider :max='100' :step='1' v-model="formData.field107"></el-slider>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="颜色选择" prop="field108" required>
            <el-color-picker v-model="formData.field108" size="medium"></el-color-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是" prop="field109">
            <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="按钮" prop="field110">
            <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        x: undefined,
        mobile: '',
        field102: undefined,
        field103: '',
        field104: 3,
        field105: undefined,
        field106: [1, 2],
        field107: 50,
        field108: null,
        field109: undefined,
        field110: undefined,
      },
      rules: {
        x: [{
          required: true,
          message: 'aaama',
          trigger: 'blur'
        }],
        mobile: [{
          required: true,
          message: '请输入手机号',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        field102: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field103: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }],
        field104: [{
          required: true,
          message: '计数器',
          trigger: 'blur'
        }],
        field105: [{
          required: true,
          message: '请选择下拉选择',
          trigger: 'change'
        }],
        field106: [{
          required: true,
          type: 'array',
          message: '请至少选择一个field106',
          trigger: 'change'
        }],
      },
      field105Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field106Options: [],
      field106Props: {
        "multiple": false
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
    getField106Options() {
      // TODO 发起请求获取数据
      this.field106Options
    },
  }
}

</script>
<style>
</style>
