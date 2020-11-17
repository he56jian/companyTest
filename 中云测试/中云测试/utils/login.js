
const { driver } = require('../support/web_driver');

console.log("login");
async function loginning(){
    await driver.get("http://uliancloudtest.uovcloud.com");
    await driver.findElement({ id: 'login-user-name' }).sendKeys("uovision020@163.com");
    await driver.findElement({ id: 'login-user-password' }).sendKeys("uovisiontest123");
    await driver.findElement({ css: '.tjbtn-log-in' }).click();
}

exports.loginning = loginning()


