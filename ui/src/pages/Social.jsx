import React from 'react'
export default function Social({apiBase}){
  const [text,setText] = React.useState('Kitchen remodel special: free sink with countertops!')
  const [platforms,setPlatforms] = React.useState(['facebook','instagram','google'])
  const [result,setResult] = React.useState(null)
  const token = localStorage.getItem('token')
  const toggle = (p)=>{ setPlatforms(prev => prev.includes(p) ? prev.filter(x=>x!==p) : [...prev,p]) }
  const post = async ()=>{
    const res = await fetch(apiBase+'/social/post', { method:'POST', headers:{'Content-Type':'application/json', 'Authorization': token||''}, body: JSON.stringify({text, platforms}) })
    setResult(await res.json())
  }
  return (
    <div style={{display:'grid', gap:12, maxWidth:700}}>
      <h3>Post Social Updates</h3>
      <textarea value={text} onChange={e=>setText(e.target.value)} rows={5}/>
      <div>{['facebook','instagram','google'].map(p => (
        <label key={p} style={{marginRight:12}}>
          <input type="checkbox" checked={platforms.includes(p)} onChange={()=>toggle(p)} /> {p}
        </label>))}
      </div>
      <button onClick={post}>Post</button>
      {result && <pre>{JSON.stringify(result,null,2)}</pre>}
    </div>
  )
}
