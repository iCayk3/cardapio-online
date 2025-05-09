import { BrowserRouter, Route, Routes } from "react-router-dom"
import Login from "./Pages/Login"
import Dashboard from "./Pages/Dashboard"
import PrivateRoute from "./Componentes/PrivateRoute"
import Cadastro from "./Pages/Cadastro"
import Cardapio from "./Pages/Cardapio"


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
        <Route
          path="/cardapio"
          element={
            <PrivateRoute >
              <Cardapio />
            </PrivateRoute>
          }
        />
      </Routes>
    </BrowserRouter>
  )
}

export default Rotas
