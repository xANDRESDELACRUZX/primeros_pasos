import './style.css'
import typescriptLogo from './typescript.svg'
import viteLogo from '/vite.svg'
import { setupCounter } from './counter.ts'
//import './clases/01-basic-types.ts'
//import './clases/02-object-interface.ts'
//import './clases/03-funcions.ts'
//import './clases/04-homeWork-type.ts'
//import './clases/05-destructuring.ts'
//import './clases/06-funcitons-destructuring.ts'
//import './clases/07-import-export.ts'
//import './clases/08-clases.ts'
//import './clases/09-generios.ts'
//import './clases/10-decorations.ts'
import './clases/11-optional-chaining.ts'
document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
  <div>
    <a href="https://vitejs.dev" target="_blank">
      <img src="${viteLogo}" class="logo" alt="Vite logo" />
    </a>
    <a href="https://www.typescriptlang.org/" target="_blank">
      <img src="${typescriptLogo}" class="logo vanilla" alt="TypeScript logo" />
    </a>
    <h1>Vite + TypeScript</h1>
    <div class="card">
      <button id="counter" type="button"></button>
    </div>
    <p class="read-the-docs">
      Click on the Vite and TypeScript logos to learn more
    </p>
  </div>
`
setupCounter(document.querySelector<HTMLButtonElement>('#counter')!)
