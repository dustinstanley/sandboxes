import axios from 'axios';

// creates an instance of the axios client, initialized with some default properties
export default axios.create({
  baseURL: 'https://api.unsplash.com',
  headers: {
    Authorization: 'Client-ID d13a433b86212a7790533f1895150526650fe2bb4ca6ad6dd94162a03506d1f2'
  }
});