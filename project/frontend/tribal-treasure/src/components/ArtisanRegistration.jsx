import React, { useState } from "react";
import axios from "axios"; // Import axios
import "../styles/artisanlogin.css"; 

function ArtisanRegistration() {
  const [formData, setFormData] = useState({
    aafname: "",
    aalname: "",
    aausername: "",
    aadob: "",
    aagender: "",
    aaemail: "",
    aaphonenumber: "",
    aapassword: "",
    aaaddress: "",
    aaskills:"",
    aashopName:""

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
     const response=await axios.post("http://localhost:1981/insertartisan",formData)
     if(response.status==200){
         setMessage(response.data)
     }

    } catch (error) {
     setMessage(error.message)

    }
 };
  return (
    <div className="artisan">
      
      <div className="container">
      {
                message?
                <p>{message}</p>:
                <p></p>
            }
        <h1>Add Artisan</h1>
        
        <form onSubmit={handleSubmit}>
          <label htmlFor="aafname">First Name</label>
          <input
            type="text"
            id="aafname"
            name="aafname"
            value={formData.aafname}
            onChange={handleChange}
            required
          />

          <label htmlFor="aalname">Last Name</label>
          <input
            type="text"
            id="aalname"
            name="aalname"
            value={formData.aalname}
            onChange={handleChange}
            required
          />

          <label htmlFor="aausername">Username</label>
          <input
            type="text"
            id="aausername"
            name="aausername"
            value={formData.aausername}
            onChange={handleChange}
            required
          />

          <label htmlFor="aadob">Date of Birth</label>
          <input
            type="date"
            id="aadob"
            name="aadob"
            value={formData.aadob}
            onChange={handleChange}
            required
          />

          <label htmlFor="aagender">Gender</label>
          <select
            id="aagender"
            name="aagender"
            value={formData.aagender}
            onChange={handleChange}
            required
          >
            <option value="">Select Gender</option>
            <option value="Female">Female</option>
            <option value="Male">Male</option>
            <option value="Other">Other</option>
          </select>

          <label htmlFor="aaemail">Email Address</label>
          <input
            type="email"
            id="aaemail"
            name="aaemail"
            value={formData.aaemail}
            onChange={handleChange}
            required
          />

          <label htmlFor="aaphonenumber">Phone Number</label>
          <input
            type="number"
            id="aaphonenumber"
            name="aaphonenumber"
            value={formData.aaphonenumber}
            onChange={handleChange}
            required
          />

          <label htmlFor="aapassword">Password</label>
          <input
            type="password"
            id="aapassword"
            name="aapassword"
            value={formData.aapassword}
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

          <label htmlFor="aaaddress">Address</label>
          <input
            type="text"
            id="aaaddress"
            name="aaaddress"
            value={formData.aaaddress}
            onChange={handleChange}
            required
          />
          <label htmlFor="aaskills">Skills</label>
          <input
            type="text"
            id="aaskills"
            name="aaskills"
            value={formData.aaskills}
            onChange={handleChange}
            required
          />
          <label htmlFor="aashopname">Shopname</label>
          <input
            type="text"
            id="aashopname"
            name="aashopName"
            value={formData.aashopName}
            onChange={handleChange}
            required
          />

         

          <button type="submit">Add Artisan</button>
        </form>
      </div>
    </div>
  );
}

export default ArtisanRegistration;
