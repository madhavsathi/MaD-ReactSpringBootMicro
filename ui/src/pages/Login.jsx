import React from 'react'
export default function Login({apiBase, onAuth}){
  const [email,setEmail] = React.useState('admin@example.com')
  const [password,setPassword] = React.useState('admin123')
  const [error,setError] = React.useState(null)
  const submit = async (e)=>{
    e.preventDefault()
    setError(null)
    const res = await fetch(apiBase+'/auth/login', { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify({email,password}) })
    if(res.ok){ const data = await res.json(); onAuth(data.token, data.role) } else { setError('Invalid credentials') }
  }
  return (
    <form onSubmit={submit} style={{maxWidth:420, margin:'40px auto', display:'grid', gap:12}}>
      <h3>Login</h3>
      <input value={email} onChange={e=>setEmail(e.target.value)} placeholder="Email" />
      <input value={password} onChange={e=>setPassword(e.target.value)} placeholder="Password" type="password" />
      <button type="submit">Sign in</button>
      {error && <div style={{color:'red'}}>{error}</div>}
    </form>
  )
}
