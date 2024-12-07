import React, { useState } from "react";
import axios from "axios"; // Import axios for API requests
import "../styles/adminlogin.css"; // Importing the CSS for the login component
import { useNavigate } from "react-router-dom"; // Importing Link for routing

function AdminLogin() {
  const [formData, setFormData] = useState({
    username: "",
    password: ""
  });
  const [message, setMessage] = useState("");
  const navigate = useNavigate();
  
  // Handle form input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:1981/checkadminlogin", formData);
      if (response.status === 200) {
        setMessage("Login successful!");
        navigate('/adminhome')
      }
    } catch (error) {
      setMessage("Login failed. Please check your Username and password.");
    }
  };

  return (
    <div className="admin">
      <div className="container">
        <img
          alt="Logo"
          height="50"
          src="https://storage.googleapis.com/a1aa/image/sbpng9p6poI2IJAIp4oXaTOHnxjEOFL5etpe8Y5O7VWe9ShnA.jpg"
          width="50"
        />
        <h1>Admin Login</h1>
        <h2>Sign in to your account</h2>
       
        
        {/* Display success or error message */}
        {message && <p>{message}</p>}
        
        <form onSubmit={handleSubmit}>
          <input  
            type="text"
            placeholder="Username"
            name="username"
            value={formData.username}
            onChange={handleChange}
            required
          />
          <input
            type="password"
            placeholder="Password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
          <div className="remember-me">
            <label>
              <input type="checkbox" />
              Remember me
            </label>
            <a href="#">Forgot your password?</a>
          </div>
          <button type="submit">Sign in</button>
        </form>
      </div>
    </div>
  );
}

export default AdminLogin;