const { Given, When, Then } = require('cucumber');
const assert = require('assert');
const { driver } = require('../support/web_driver');
const {  By, Key, until } = require('selenium-webdriver');

Given(/^浏览到网站 "([^"]*)"$/, async function (newUrl) {
    await driver.get(newUrl);
    // await driver.sleep(1000);
    // await assert.ok(driver.getCurrentUrl() == "http://uliancloudtest.uovcloud.com/")
});
When(/^在登录名一栏输入"([^"]*)"并点击其他位置$/, async function (username) {
    await driver.findElement({ id: 'login-user-name' }).sendKeys(username);
});
When(/^在密码处，输入"([^"]*)"并点击其他位置$/, async function (pwd) {
    await driver.findElement({ id: 'login-user-password' }).sendKeys(pwd);
});

When(/^点击登录按钮$/, async function () {
    await driver.findElement({ css: '.tjbtn-log-in' }).click();
    await driver.sleep(1000)
});
Then(/^当前状态码为"([^"]*)"弹出的提示信息"([^"]*)"$/, async function (status, message) {
    let loginMessage;

    if(status == 200){
        //跳转到新的页面
        let newUrl = await driver.getCurrentUrl();
        console.log(newUrl);
        await assert.ok(newUrl == "http://uliancloudtest.uovcloud.com/html/personal_page.html")
    }else{
        //说明跳转失败tjbtn-prompt
        loginMessage = await driver.findElement(By.className("tjbtn-prompt")).getText();
        // await console.log('提示信息：' + loginMessage);
        await assert.ok(message == loginMessage);
    }
   
    
});




