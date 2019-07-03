function signUp() {
    if (CheckEmpty('#username') == 1) {
        alert('账号不能为空');
        return false;
    }
    if (CheckEmpty('#password') == 1 && CheckEmpty('#password2') == 1) {
        alert('密码不能为空');
        return false;
    }
    /*
    var code = checkCode($('#code').val());
    if (code == 0 || code == 2) {
        openAlert('验证码错误,请重新输入');
        $("#verifyImg").click();
        $('#code').val('');
        return false;
    }
    */
}
