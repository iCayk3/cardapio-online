package br.com.w4solution.lanches.service;

import br.com.w4solution.lanches.domain.item.Categoria;
import br.com.w4solution.lanches.domain.item.Item;
import br.com.w4solution.lanches.dto.CadastrarItemDto;
import br.com.w4solution.lanches.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item cadastrarItem(CadastrarItemDto dados) {
        MultipartFile imagem = dados.imagem();
        String imagemPath = null;

        if (imagem != null && !imagem.isEmpty()) {
            try {
                String nomeArquivo = UUID.randomUUID() + "_" +
                        imagem.getOriginalFilename().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");

                Path pastaUpload = Paths.get(System.getProperty("user.dir"), "imagens/imagens");
                if (!Files.exists(pastaUpload)) {
                    Files.createDirectories(pastaUpload);
                }

                Path caminhoArquivo = pastaUpload.resolve(nomeArquivo);
                Files.copy(imagem.getInputStream(), caminhoArquivo, StandardCopyOption.REPLACE_EXISTING);

                imagemPath = nomeArquivo;
            } catch (IOException e) {
                throw new RuntimeException("Erro ao salvar imagem: " + e.getMessage());
            }
        }

        Item item = new Item(dados);
        item.setImagemPath(imagemPath);

        repository.save(item);
        return item;
    }

    public List<Item> listarItens(Categoria filtro) {
        if(filtro != null){
            return repository.findAllByCategoria(filtro);
        }
        return repository.findAll();
    }
}
