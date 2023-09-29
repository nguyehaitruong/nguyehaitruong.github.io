

function chuoiDaiNhat(arr) {
    let maxLength = arr[0].length;
    let chuoiLonNhat = [arr[0]];

    for (let i = 1; i < arr.length; i++) {
        const chuoiHienTai = arr[i];
        const doDaiChuoiHienTai = chuoiHienTai.length;

        if (doDaiChuoiHienTai > maxLength) {
            maxLength = doDaiChuoiHienTai;
            chuoiLonNhat = [chuoiHienTai];
        } else if (doDaiChuoiHienTai === maxLength) {
            chuoiLonNhat.push(chuoiHienTai);
        }
    }

    return chuoiLonNhat;
}
const mangChuoi = ['aba', 'aa', 'ad', 'c', 'vcd'];
const ketQua = chuoiDaiNhat(mangChuoi);
console.log(ketQua); 
const users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
];

function DieuKien(user) {
    return user.age > 25 && user.isStatus === true;
}

const ketQua1 = users.filter(DieuKien);
console.log(ketQua1);
function getUsersByAgeAscending(users) {
    const sortedUsers = users.slice().sort((a, b) => a.age - b.age);
    return sortedUsers;
}

const ketQua2 = getUsersByAgeAscending(users);
console.log(ketQua2);

const daySo = ["one", "two", "three", "one", "one", "three"];
let one = 0;
let two = 0;
let three = 0;

for (let i = 0; i < daySo.length; i++) {
    const value = daySo[i];
    
    switch (value) {
        case "one":
            one++;
            break;
        case "two":
            two++;
            break;
        case "three":
            three++;
            break;
        default:
            break;
    }
}

console.log(`Số lần xuất hiện của "one": ${one}`);
console.log(`Số lần xuất hiện của "two": ${two}`);
console.log(`Số lần xuất hiện của "three": ${three}`);
