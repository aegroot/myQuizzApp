import React, { useState } from "react";

export default function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const changeEmail = (event) => {
    let value = event.target.value;
    setEmail(value);
  };
  const changePassword = (event) => {
    let value = event.target.value;
    setPassword(value);
  };

  const onsubmit = (event) => {
    event.preventDefault();

    let authBody = { email: email, password: password };

    fetch("http://localhost:8080/api/v1/login", {
      method: "post",
      body: JSON.stringify(authBody),

      headers: {
        "Content-Type": "application/json",
      },
    })
    .then((res)=>{
      if (!res.ok){throw res.status}
      return res.json();
      
    })
  };

  return (
    <div>
      <form action="">
        <label htmlFor="email-form">email</label>
        <label htmlFor="password-login-form">password</label>
        <input
          type="email"
          name="email"
          id="email-form"
          onChange={changeEmail}
        />
        <input
          type="password"
          name="password"
          id="password-form"
          onChange={changePassword}
        />
        <button type="submit">login</button>
      </form>
    </div>
  );
}
