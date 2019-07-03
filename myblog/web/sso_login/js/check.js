/**
 * Created by ZhaoYanfu on 2019/1/18.
 */


/*
 * Trim('value值')   返回去除空格后的字符串
 */



function Trim(str) {    //字符串去除前后空格
    return str.replace(/(^\s*)|(\s*$ )/g, "");
}


/*
 * CheckEmpty('#objid');
 * CheckEmpty('.objclass');
 */
function CheckEmpty(str) {  //判断输入为空或者输入placeholder值
    var StrValue = $(str).val();
    var StrPlaceholder = $(str).attr('placeholder');
    if (Trim(StrValue) == '' || Trim(StrValue) == StrPlaceholder) {
        return 1;
    }else{
        return CheckScript(str);
    }

}


function CheckScript(str) {    //判读输入的特殊字符
    var ScriptStr =/<[\/\!]*[^<>]*>/;
    if (ScriptStr.test(Trim($(str).val()))) {
        var astr = $(str).attr('placeholder').indexOf('请输入') == -1 ? $(str).attr('placeholder')+'输入有误,请重新输入'  :  $(str).attr('placeholder').replace('请输入','') +'输入有误,请重新输入';
        openAlert(astr);
        return 1;
    }
    return 0;
}


/*
 * CheckName('#objid');
 */
function CheckName(str) {   //验证姓名输入有误
    var str = $(str).val();
    var NameStr = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
    if (!NameStr.test(Trim(str))) {
        return 1;
    }else{
        return 0;
    }
}


/*
 * CheckChinese('#objid');
 */
function CheckChinese(str) {  //验证是否输入纯中文
    var str = $(str).val();
    var ChineseStr = /^[\u4e00-\u9fa5]+$/;
    if (!ChineseStr.test(Trim(str))) {
        return 1;
    }else{
        return 0;
    }

}

/*
 * CheckNumber('#objid');
 */
function CheckNumber(str) {  //验证是否输入纯数字
    var str = $(str).val();
    var NumberStr = /^[0-9]*$/;
    if (!NumberStr.test(Trim(str))) {
        return 1;
    }else{
        return 0;
    }

}


/*
 * CheckCard('#objid');
 */
function CheckCard(str) {  //验证身份证号是否正确
    var str = $(str).val();
    var CardStr = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    if (!CardStr.test(Trim(str))) {
        return 1;
    }else{
        return 0;
    }

}


/*
 * CheckPhone('#objid');
 */
function CheckPhone(str) {  //验证手机号是否正确
    var str = $(str).val();
    var PhoneStr = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!PhoneStr.test(Trim(str))) {
        return 1;
    }else{
        return 0;
    }

}


/*
 * CheckNumberAbc('#objid');
 */
function CheckNumberAbc(str) {  //验证26个字母加数字
    var str = $(str).val();
    var NumberAbc = /^[A-Za-z0-9]+$/;
    if (!NumberAbc.test(Trim(str))) {
        return 1;
    }else{
        return 0;
    }

}



