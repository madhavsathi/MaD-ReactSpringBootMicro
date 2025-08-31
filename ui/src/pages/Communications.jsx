import React from 'react'
export default function Communications({apiBase}){
  const [contacts,setContacts]=React.useState([])
  const [comms,setComms]=React.useState([])
  React.useEffect(()=>{
    fetch(apiBase+'/crm/contacts').then(r=>r.json()).then(d=>setContacts(d.contacts||[]))
    fetch(apiBase+'/crm/communications').then(r=>r.json()).then(d=>setComms(d.communications||[]))
  },[])
  return (
    <div style={{display:'grid', gap:16}}>
      <h3>Contacts</h3>
      <ul>{contacts.map((c,i)=><li key={i}>{c.name} — {c.email} — {c.phone}</li>)}</ul>
      <h3>Communication History</h3>
      <ul>{comms.map((c,i)=><li key={i}>{c.contact} — {c.channel}: {c.summary}</li>)}</ul>
    </div>
  )
}
