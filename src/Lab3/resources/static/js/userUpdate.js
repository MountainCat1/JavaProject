

let xhr = new XMLHttpRequest();
xhr.open("POST", "http://localhost:8081/api/user/1/update");

xhr.setRequestHeader("Accept", "application/json");
xhr.setRequestHeader("Content-Type", "application/json");

xhr.onload = () => console.log(xhr.responseText);

let data = `{
  "id": 0,
  "email": "updatedUser@mail.com",
  "name": "updatedUser"
}`;

console.log("sending json file...")
xhr.send(data);

