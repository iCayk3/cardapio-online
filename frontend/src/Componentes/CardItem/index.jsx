import * as React from 'react';
import AspectRatio from '@mui/joy/AspectRatio';
import Button from '@mui/joy/Button';
import Card from '@mui/joy/Card';
import CardContent from '@mui/joy/CardContent';
import IconButton from '@mui/joy/IconButton';
import Typography from '@mui/joy/Typography';
import Add from '@mui/icons-material/Add';
import { Accordion, AccordionDetails, AccordionSummary } from '@mui/joy';
// import BookmarkAdd from '@mui/icons-material/BookmarkAddOutlined';

const apiUrl = "http://localhost:8080/imagens/";

export default function CardItem({valor, imagem, nome, descricao}) {
  return (
    <Card sx={{ width: 320 }}>
      <div>
        <Typography level="title-lg">{nome}</Typography>

        <IconButton
          aria-label="bookmark Bahamas Islands"
          variant="solid"
          color="success"
          size="sm"
          sx={{ position: 'absolute', top: '0.875rem', right: '0.5rem' }}
        >
          <Add />
        </IconButton>
      </div>
      <AspectRatio minHeight="120px" maxHeight="200px">
        <img
          src={apiUrl+imagem}
          srcSet="https://images.unsplash.com/photo-1527549993586-dff825b37782?auto=format&fit=crop&w=286&dpr=2 2x"
          loading="lazy"
          alt=""
        />
      </AspectRatio>
      <CardContent orientation="horizontal">
        <div>
          <Typography level="body-xs">Preço :</Typography>
          <Typography sx={{ fontSize: 'lg', fontWeight: 'lg' }}>R$ {valor}</Typography>
        </div>
      </CardContent>
      <Accordion sx={{ fontWeight: 600, boxSizing: 'content-box' }}>
        <AccordionSummary indicator={null} >
          {/* <Button
            variant="solid"
            size="md"
            color="primary"
            aria-label="Explore Bahamas Islands"
            sx={{ alignSelf: 'center', fontWeight: 600 }}
          >
            
          </Button> */}
          Descrição do produto
        </AccordionSummary>
        <AccordionDetails>
          <span>
            {descricao}
          </span>
        </AccordionDetails>
      </Accordion>
    </Card>
  );
}