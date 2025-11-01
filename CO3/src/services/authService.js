import axios from "axios";

const API_URL = "http://65.0.169.144:8083/back1/auth";

export const login = async (username, password) => {
  const response = await axios.post(`${API_URL}/login`, { username, password });
  localStorage.setItem("token", response.data);
  return response.data;
};

export const signup = async (username, email, password) => {
  return axios.post(`${API_URL}/sign`, { username, email, password });
};

export const logout = () => {
  localStorage.removeItem("token");
};
