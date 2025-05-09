import { FormControl, FormHelperText, FormLabel, Input } from "@mui/joy"
import styled from "styled-components"

const estilosInput = {
    mt: 1
}

const InputLabelEstilizado = styled.div`
    font-size: 1.2rem;
    font-weight: 500;
    color: #7FFBC5;;
    position: relative;
    .messagem{
        font-size: 1rem;
        color: #C41C1C;
    }
`

const InputLabel = ({ label, cor, tamanho, variante, tipo, valor, aoAlterado, messagem, estilos, status = 200 }) => {


    return <InputLabelEstilizado>
        {status === 200 ? <FormControl>
            <FormLabel sx={estilos}>{label}</FormLabel>
            <Input
                value={valor}
                onChange={aoAlterado}
                sx={estilosInput}
                // color={cor}
                size={tamanho}
                variant={variante}
                type={tipo}
            />
            <FormHelperText color={cor}>
                {messagem}
            </FormHelperText>
        </FormControl> :
            <FormControl error>
                <FormLabel sx={estilos}>{label}</FormLabel>
                <Input
                    value={valor}
                    onChange={aoAlterado}
                    sx={estilosInput}
                    color={cor}
                    size={tamanho}
                    variant={variante}
                    type={tipo}
                    error
                />
                <FormHelperText error>
                    {messagem}
                </FormHelperText>
            </FormControl>
        }
    </InputLabelEstilizado>
}

export default InputLabel