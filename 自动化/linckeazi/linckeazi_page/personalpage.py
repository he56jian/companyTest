from linckeazi.linckeazi_page.basepage import BasePage


class PersonalPage(BasePage):
    _status = 'today'  # personal页面默认选择选项；

    def add_device(self):
        # 添加相机
        pass

    def go_top(self):
        # 置顶
        pass

    def clear_storge(self):
        # 清除空间
        pass

    def show_today(self):
        # 显示今天内容
        pass

    def show_history(self):
        # 显示以前内容
        pass

    def show_collection(self):
        # 显示收藏内容
        pass

    def do_collection(self):
        # 图片收藏
        pass

    def do_share(self):
        # 分享图片
        pass

    def show_total(self):
        # 显示所有图片
        return SuperViewPage()

    def show_setting(self):
        # 显示当前设置
        return SettingPage()

    def show_location(self):
        # 显示当前位置
        return LocationPage()

    def do_getpic(self):
        # 获取一张图片
        pass

    def show_more(self):
        # 展示更多
        pass
