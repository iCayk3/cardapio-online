import { BrowserRouter, Route, Routes } from "react-router-dom"
import Login from "./Pages/Login"
import Dashboard from "./Pages/Dashboard"
import PrivateRoute from "./Componentes/PrivateRoute"
import Cadastro from "./Pages/Cadastro"


function Rotas() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/login' element={<Login />} />
        <Route path='/cadastro' element={<Cadastro />} />
        <Route
          path="/"
          element={
            <PrivateRoute >
              <Dashboard />
            </PrivateRoute>
          }
        />
      </Routes>
    </BrowserRouter>
  )
}

export default Rotas
