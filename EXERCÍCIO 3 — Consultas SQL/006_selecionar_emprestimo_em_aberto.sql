SELECT u.nome AS usuario,
       i.titulo AS item,
       e.data_retirada,
       e.data_devolucao_prevista
FROM emprestimo e
JOIN usuario u ON u.id = e.usuario_id
JOIN item i    ON i.id = e.item_id
WHERE e.data_devolucao IS NULL
ORDER BY u.nome;