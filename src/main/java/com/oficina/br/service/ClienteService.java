package com.oficina.br.service;

import com.oficina.br.dto.ClienteDTO;
import com.oficina.br.mapper.ClienteMapper;
import com.oficina.br.model.Cliente;
import com.oficina.br.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoService enderecoService;

    public ClienteService(ClienteRepository clienteRepository, EnderecoService enderecoService) {
        this.clienteRepository = clienteRepository;
        this.enderecoService = enderecoService;
    }

    @Transactional(readOnly = true)
    public ClienteDTO buscarPorId(Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        return montarCliente(cliente);
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> buscarTodos() {
        var list = clienteRepository.findAll();
        return list.stream().map(this::montarCliente).toList();
    }

    @Transactional
    public void salvarCliente(ClienteDTO clienteDTO) {
        log.info("salvando cliente");
        Cliente cliente = ClienteMapper.INSTANCE.toClienteEntity(clienteDTO);
        if (cliente.getId() == null) {
            cliente.setAtivo(true);
        }

        final var clienteSalvo = clienteRepository.save(cliente);
        enderecoService.salvarEndereco(clienteDTO.getEnderecoDTO(), clienteSalvo, null);
    }

    @Transactional
    public void desativarClientePorId(Long id) {
        clienteRepository.desativarCliente(id);
    }

    private ClienteDTO montarCliente(Cliente cliente) {
        var clienteDTO = ClienteMapper.INSTANCE.toClienteDTO(cliente);
        clienteDTO.setEnderecoDTO(enderecoService.buscarEnderecoPorIdCliente(clienteDTO.getId()));
        return clienteDTO;
    }
}
