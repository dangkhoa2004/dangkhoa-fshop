document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/configurationAPI')
            .then(response => response.json())
            .then(data => {
                const isLogin = data.login;
                const name = data.name;
                const ipv4Address = data.ipv4Address;
                const ipv6Address = data.ipv6Address;
                const deviceName = data.deviceName;
                const timestamp = data.timestamp;
                const userRole = data.userRole;
                const sessionDuration = data.sessionDuration;
                const browserInfo = data.browserInfo;
                const operatingSystem = data.operatingSystem;
                const appVersion = data.appVersion;
                const userLinkElement = document.getElementById('user-link');
                const deviceInfoElement = document.getElementById('device-info');

                if (isLogin && name !== undefined) {
                    userLinkElement.innerHTML = `
    <li class="nav-item" id="user-link">
        <a class="nav-link" href="#" id="dropdownMenuButton">
            <i class="fa-solid fa-circle-user"></i> ${name}</a>
            <ul class="dropdown-menu">
                <li><a class="nav-link" href="/mouses"><i class="fa-solid fa-life-ring"></i> Quản lý</a></li>
                <li><a class="nav-link" href="/logout"><i class="fa-solid fa-arrow-right-from-bracket"></i> Đăng Xuất</a></li>
            </ul>
    </li>`;
                    deviceInfoElement.innerHTML = `
                    IPv4: ${ipv4Address || 'N/A'}, 
                    IPv6: ${ipv6Address || 'N/A'}, 
                    Device: ${deviceName}, 
                    Timestamp: ${timestamp}, 
                    Role: ${userRole}, 
                    Session Duration: ${sessionDuration} seconds, 
                    Browser: ${browserInfo}, 
                    OS: ${operatingSystem}, 
                    App Version: ${appVersion}
                `;
                } else {
                    userLinkElement.innerHTML = '<a class="nav-link" href="/login"><i class="fa-solid fa-right-to-bracket"></i> Đăng Nhập</a>';
                    deviceInfoElement.innerHTML = '';
                }
            })
            .catch(error => console.error('Error:', error));
});