import requests

url = "http://v.juhe.cn/weather/index"
para = {"cityname":"北京","key":"ed707e2d6982ea464d85d50255fef135"}

# 发送请求
r = requests.get(url,params=para)
# 获取json数据
res = r.json()
print(res["result"]["sk"])
