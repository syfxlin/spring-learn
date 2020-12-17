<#ftl encoding="UTF-8">
<#-- 一些设置 -->
<#setting locale="zh_CN">
<#import "/spring.ftl" as spring>
<!doctype html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <#-- 插值 -->
  <title>${title}</title>
</head>
<body>
<#-- if 和 不为 null 判断 -->
<#if title??>
  <h1>${title}</h1>
<#elseif title??>
<#else>
</#if>
<#-- 循环 -->
<#-- List -->
<ul>
  <#list users as user>
    <li>name: ${user.name}, age: ${user.age}, uuid: ${user.uuid}</li>
  </#list>
</ul>
<ul>
  <#list users>
    <#items as user>
      <li>name: ${user.name}, age: ${user.age}, uuid: ${user.uuid} <#sep>and</#sep></li>
    </#items>
  </#list>
</ul>
<#-- Array, List -->
<ul>
  <#list [0, 1, 2, 3] as i>
    <li>${i}</li>
  </#list>
</ul>
<#-- Range -->
<ul>
  <#list 0..3 as i>
    <li>${i}</li>
    <#break>
  </#list>
</ul>
<#-- Map -->
<ul>
  <#list {"key": "value"} as key, value>
    <li>key: ${key}, value: ${value}</li>
  </#list>
</ul>
<#-- 子元素，适用于 Array，List，String 等 -->
<p>${"substrsubstr"[0..5]}</p>
<#-- 默认值 -->
<p>${nullValue!"default value"}</p>
<#-- 设置全局变量 -->
<#assign value="value">
<#-- 设置局部变量 -->
<#macro local>
  <#local value="value">
</#macro>
<#-- 设置超全局变量 -->
<#global gloalValue="value">
<#-- 类型转换 -->
<p>${1?string}</p>
<#-- 自定义指令 -->
<#macro custom val>
  <p>macro ${val}</p>
</#macro>
<@custom val='123'></@custom>
<#-- 插槽 -->
<#macro nested>
  <div style="color: blue">
    <#nested>
  </div>
</#macro>
<@nested>
  nested content
</@nested>
<#macro do_thrice str>
    <#nested 1>
    <#nested 2>
    <#nested 3>
</#macro>
<@do_thrice str="str" ; x>
    ${x} Anything.
</@do_thrice>
<#-- 带命令空间导入 -->
<#import "lib.ftl" as lib>
<@lib.date '2020'></@lib.date>
<#-- 直接导入 -->
<#include "lib.ftl">
<@date '2021'></@date>
<#-- Map keySet values -->
<ul>
  <#list userMap?keys as key>
    <li>${key}, index: ${key?index}, hasNext: ${key?has_next?string}, isFirst: ${key?is_first?string}, isLast: ${key?is_last?string}</li>
  </#list>
</ul>
<#-- try catch 内容 -->
<#attempt>
  Optional content: ${thisMayFails}
  <#recover>
  Ops! The optional content is not available.
</#attempt>
<#-- 函数 -->
<#function add a b>
  <#return a + b>
</#function>
<p>1 + 1 = ${add(1, 1)}</p>
<#-- Switch -->
<#switch 1>
  <#case 1>
    case 1
    <#break>
  <#case 2>
    case 2
    <#break>
  <#default>
</#switch>
<#-- Map item -->
<p>${userMap['name1'].uuid}</p>
<#-- 国际化 -->
<p><@spring.messageArgs code="example.welcome" args=["Admin"] /></p>
</body>
</html>