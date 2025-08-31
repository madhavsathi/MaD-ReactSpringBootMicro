import React from 'react'
export default function Responses({apiBase}){
  const [threads,setThreads] = React.useState([])
  React.useEffect(()=>{ fetch(apiBase+'/email/threads').then(r=>r.json()).then(d=>setThreads(d.threads||[])) },[])
  return (
    <div>
      <h3>Email Responses (Gmail stub)</h3>
      <ul>{threads.map(t => <li key={t.id}><b>{t.subject}</b> — {t.from} — {t.snippet}</li>)}</ul>
    </div>
  )
}
