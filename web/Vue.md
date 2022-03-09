# Vue

Vue (读音 /vjuː/，类似于 **view**) 是一套用于构建用户界面的**渐进式框架**。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与[现代化的工具链](https://cn.vuejs.org/v2/guide/single-file-components.html)以及各种[支持类库](https://github.com/vuejs/awesome-vue#libraries--plugins)结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。

```
new Date().toLocaleString()//时间转换
```

使用

```
<div id="app">
	<h2>a {{bianliangming}}</h2>
</div>
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>//学习和制作用
<script>
	const app = new Vue({
        el: '#app',
        data: {
            bianliangming: 'book'
        } 
        
	})
</script>
```

```
v-bind:title='变量名'//鼠标停留后提示变量值
```



// $watch 是一个实例方法
vm.$watch('a', function (newValue, oldValue) {
// 这个回调将在 `vm.a` 改变后调用
})



创建vue对象的生命周期图

![lifecycle](D:\studys\web\lifecycle.png)

### NPM

在用 Vue 构建大型应用时推荐使用 NPM 安装[[1\]](https://cn.vuejs.org/v2/guide/installation.html#footnote-1)。NPM 能很好地和诸如 [webpack](https://webpack.js.org/) 或 [Browserify](http://browserify.org/) 模块打包器配合使用。同时 Vue 也提供配套工具来开发[单文件组件](https://cn.vuejs.org/v2/guide/single-file-components.html)。

```
# 最新稳定版
$ npm install vue
```

