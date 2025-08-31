import React from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route, Link, Navigate, useNavigate } from 'react-router-dom'
import Login from './pages/Login.jsx'
import Social from './pages/Social.jsx'
import Responses from './pages/Responses.jsx'
import Communications from './pages/Communications.jsx'
import Zoho from './pages/Zoho.jsx'
const apiBase = import.meta.env.VITE_API_BASE || 'http://localhost:8080'
function AppShell(){
  const [token,setToken] = React.useState(localStorage.getItem('token'))
  const [role,setRole] = React.useState(localStorage.getItem('role'))
  const navigate = useNavigate()
  const logout = () => { localStorage.clear(); setToken(null); setRole(null); navigate('/login') }
  return (
    <div style={{fontFamily:'Inter, system-ui', padding:16}}>
      <header style={{display:'flex', gap:16, alignItems:'center'}}>
        <h2 style={{marginRight:'auto'}}>ReactSpringBootMicro</h2>
        <Link to="/social">Social Posts</Link>
        <Link to="/responses">Responses</Link>
        <Link to="/communications">Communications</Link>
        <Link to="/zoho">Zoho</Link>
        {token ? <button onClick={logout}>Logout</button> : <Link to="/login">Login</Link>}
      </header>
      <main style={{marginTop:16}}>
        <Routes>
          <Route path="/" element={<Navigate to={token?"/social":"/login"} replace />} />
          <Route path="/login" element={<Login apiBase={apiBase} onAuth={(t,r)=>{ localStorage.setItem('token',t); localStorage.setItem('role',r); setToken(t); setRole(r); navigate('/social'); }} />} />
          <Route path="/social" element={<Social apiBase={apiBase} />} />
          <Route path="/responses" element={<Responses apiBase={apiBase} />} />
          <Route path="/communications" element={<Communications apiBase={apiBase} />} />
          <Route path="/zoho" element={<Zoho apiBase={apiBase} />} />
        </Routes>
      </main>
    </div>
  )
}
createRoot(document.getElementById('root')).render(<BrowserRouter><AppShell/></BrowserRouter>)
