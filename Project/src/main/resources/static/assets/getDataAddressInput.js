// Lấy các giá trị từ các ô đã chọn
const selectedProvince = document.getElementById("provinceSelect").textContent;
const selectedDistrict = document.getElementById("districtSelect").textContent;
const selectedWard = document.getElementById("wardSelect").textContent;

document.getElementById("submitButton").addEventListener("change",function () {
// Tạo một đối tượng chứa dữ liệu cần gửi
    const data = {
        addressLine1: selectedProvince,
        addressLine12: selectedDistrict,
        addressLine13: selectedWard
    };

// Thực hiện POST request đến URL của ứng dụng Spring
    fetch("http://localhost:8080/profile/update", {
        method: "POST",
        headers: {
            "Content-Type": "application/json;charset=UTF-8"
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.status === 200) {
                // Xử lý phản hồi từ server nếu cần
                console.log("Dữ liệu đã được gửi thành công.");
            } else {
                console.error("Lỗi khi gửi dữ liệu.");
            }
        })
        .catch(error => {
            console.error("Lỗi khi gửi dữ liệu:", error);
        });
});
