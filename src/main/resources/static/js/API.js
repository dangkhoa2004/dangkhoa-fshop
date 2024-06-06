document.addEventListener('DOMContentLoaded', function () {
  fetch('http://localhost:8080/configurationAPI')
  .then(response => response.json())
  .then(data => {
    const isLogin = data.login;
    const role = data.roleString;
    const userRole = role === 1 ? 'ADMIN' : role === 2 ? 'USER' : 'UNKNOWN'; // Role mapping
    const ipv4Address = data.ipv4Address;
    const ipv6Address = data.ipv6Address;
    const deviceName = data.deviceName;
    const timestamp = data.timestamp;
    const sessionDuration = data.sessionDuration;
    const browserInfo = data.browserInfo;
    const operatingSystem = data.operatingSystem;
    const appVersion = data.appVersion;
    const userLinkElement = document.getElementById('user-link');
    const deviceInfoElement = document.getElementById('device-info');

    if (isLogin && role !== undefined) {
      userLinkElement.innerHTML = `<a class="nav-link" href="/logout"><i class="fa-solid fa-circle-user"></i> ${role}</a>`;
      deviceInfoElement.innerHTML = `
                    Role: ${userRole},
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