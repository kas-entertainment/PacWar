/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const axios = axios.create({
    baseURL: 'https://localhost:8080/',
    timeout: 1000,
    headers: {'X-Custom-Header': 'foobar'}
});

var ApiRestControllerModule = (function () {
    axios.axios({
        method: 'post',
        url: '/register',
        data: {
            name:document.getElementById('name').value,
            lastName:document.getElementById('lastName').value,
            mail:document.getElementById('mail'),
            nickName:document.getElementById('nickName'),
            password:document.getElementById('password'),
            
        }
    });
})();
