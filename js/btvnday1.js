function calculateFactorial(number=5) {
    if (number < 0) {
        return "Không có giai thừa cho số âm";
    } else if (number === 0 || number === 1) {
        return 1;
    } else {
        let factorial = 1;
        for (let i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
function reverseString(str="hello") {
    
    
    for (let i = str.length - 1; i >= 0; i--) {
        reversedStr += str[i];
    }
    
    return reversedStr;
}
function substring(str) {
    if (str.length > 15) {
        let substr = "";
        for (let i = 0; i < 10; i++) {
            substr += str[i];
        }
        substr += "...";
        return substr;
    } else {
        return str;
    }
}
function translate(countryCode) {
    let message;

    switch (countryCode) {
        case 'VN':
            message = 'Xin chào';
            break;
        case 'EN':
            message = 'Hello';
            break;
        default:
            message = 'Mã quốc gia không được hỗ trợ';
    }

    return message;
}



