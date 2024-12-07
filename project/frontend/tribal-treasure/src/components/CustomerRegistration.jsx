import React, { useState } from "react";
import axios from "axios"; // Import axios
import "../styles/customerlogin.css"; 

function CustomerRegistration() {
  const [formData, setFormData] = useState({
    cfname: "",
    clname: "",
    cusername: "",
    cdob: "",
    cgender: "",
    cemail: "",
    cphonenumber: "",
    cpassword: "",
    caddress: ""
  });
  const [message, setMessage] = useState("");

  
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  
  const handleSubmit = async (e) => {
    try {
     e.preventDefault()
     const response=await axios.post("http://localhost:1981/insertcustomer",formData)
     if(response.status==200){
         setMessage(response.data)
     }

    } catch (error) {
     setMessage(error.message)

    }
 };
  return (
    <div className="customer">
      {
                message?
                <p>{message}</p>:
                <p></p>
            }
      <div className="container">
        <h1>Create your account</h1>
        <p>
          Already have an account? <a href="#">Sign in</a>
        </p>
        <form onSubmit={handleSubmit}>
          <label htmlFor="cfname">First Name</label>
          <input
            type="text"
            id="cfname"
            name="cfname"
            value={formData.cfname}
            onChange={handleChange}
            required
          />

          <label htmlFor="clname">Last Name</label>
          <input
            type="text"
            id="clname"
            name="clname"
            value={formData.clname}
            onChange={handleChange}
            required
          />

          <label htmlFor="cusername">Username</label>
          <input
            type="text"
            id="cusername"
            name="cusername"
            value={formData.cusername}
            onChange={handleChange}
            required
          />

          <label htmlFor="cdob">Date of Birth</label>
          <input
            type="date"
            id="cdob"
            name="cdob"
            value={formData.cdob}
            onChange={handleChange}
            required
          />

          <label htmlFor="cgender">Gender</label>
          <select
            id="cgender"
            name="cgender"
            value={formData.cgender}
            onChange={handleChange}
            required
          >
            <option value="">Select Gender</option>
            <option value="Female">Female</option>
            <option value="Male">Male</option>
            <option value="Other">Other</option>
          </select>

          <label htmlFor="cemail">Email Address</label>
          <input
            type="email"
            id="cemail"
            name="cemail"
            value={formData.cemail}
            onChange={handleChange}
            required
          />

          <label htmlFor="cphonenumber">Phone Number</label>
          <input
            type="number"
            id="cphonenumber"
            name="cphonenumber"
            value={formData.cphonenumber}
            onChange={handleChange}
            required
          />

          <label htmlFor="cpassword">Password</label>
          <input
            type="password"
            id="cpassword"
            name="cpassword"
            value={formData.cpassword}
            onChange={handleChange}
            required
          />

          <label htmlFor="confirm-password">Confirm Password</label>
          <input
            type="password"
            id="confirm-password"
            name="confirm-password"
            required
          />

          <label htmlFor="caddress">Address</label>
          <input
            type="text"
            id="caddress"
            name="caddress"
            value={formData.caddress}
            onChange={handleChange}
            required
          />

          <div className="checkbox-container">
            <input type="checkbox" id="terms" name="terms" required />
            <label htmlFor="terms">
              I agree to the <a href="#">Terms of Service</a> and{" "}
              <a href="#">Privacy Policy</a>
            </label>
          </div>

          <button type="submit">Create Account</button>
        </form>
      </div>
    </div>
  );
}

export default CustomerRegistration;
