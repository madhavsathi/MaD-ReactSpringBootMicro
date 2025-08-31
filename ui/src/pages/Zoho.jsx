import React from 'react'
export default function Zoho({apiBase}){
  const [status,setStatus] = React.useState(null)
  const sync = async ()=>{ const res = await fetch(apiBase+'/crm/zoho/sync',{method:'POST'}); setStatus(await res.json()) }
  return (
    <div>
      <h3>Zoho CRM Integration</h3>
      <button onClick={sync}>Sync Now</button>
      {status && <pre>{JSON.stringify(status,null,2)}</pre>}
    </div>
  )
}
