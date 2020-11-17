from linckeazi.linckeazi_page.basepage import BasePage


class DeviceSettingsPage(BasePage):

    def __init__(self, deivceID=0):
        self._currentDeviceID = deivceID

    def show_device_settings(self, deviceID=1):
        # 显示相机设置
        return self

    def set_deviceID(self, deviceID):
        # 设置显示的相机
        return self

    def set_phone_code(self, code):
        # 设置国家号码
        return self

    def set_number(self, number):
        # 填写电话号码
        return self

    def set_on_time(self, zone='Beijing'):
        # 打开时区开关,并设置为东八区
        return self

    def set_off_time(self):
        # 关闭时区开关
        return self

    def set_on_summer(self):
        # 开启夏令时
        return self

    def set_off_summer(self):
        # 关闭夏令时
        return self

    def set_quick_setup(self, step=0):
        # 设置快捷设置
        return self

    def set_camera_mode(self, mode=0, size=0, burst=0, burst_speed=0, option=0, shutter_speed=0, flash=0, length=0):
        # 设置相机camera mode参数
        return self

    def set_trigger(self, mode=0, sensitivity=0, interval=0, timelapse=0):
        # 设置相机trigger参数
        return self

    def set_worktime1(self, week=['all'], start="00:00", stop='00:00'):
        # 设置worktime时间
        return self

    def set_worktime2(self, week=['all'], start="00:00", stop='00:00'):
        # 设置worktime时间
        return self

    def set_worktime3(self, week=['all'], start="00:00", stop='00:00'):
        # 设置worktime时间
        return self

    def set_worktime4(self, week=['all'], start="00:00", stop='00:00'):
        # 设置worktime时间
        return self

    def show_worktime(self):
        # 显示worktime时间
        return self

    def set_send_mode(self, instant=0):
        # 设置send mode
        return self

    def set_remote_control(self, respond=0):
        # 设置remote control
        return self

    def set_rename(self, rename):
        # 设置rename
        return self

    def set_on_overwrite(self):
        # 开启overwrite
        return self

    def set_off_overwrite(self):
        # 关闭overwrite
        return self

    def set_on_gps(self):
        # 开启gps
        return self

    def set_off_gps(self):
        # 关闭gps
        return self
