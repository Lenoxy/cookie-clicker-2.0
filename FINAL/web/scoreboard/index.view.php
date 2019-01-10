
<table>
    <tr id = header>
        <th>Name</th>
        <th>ID</th>
        <th>Score</th>
    </tr>

    <?php foreach($allscores as $score):?>
        <tr>
           <td> <?= htmlspecialchars($score['name'], ENT_QUOTES, "UTF-8"); ?></td>
           <td><?= htmlspecialchars($score['id'], ENT_QUOTES, "UTF-8"); ?></td>
           <td><?= htmlspecialchars($score['score'], ENT_QUOTES, "UTF-8"); ?></td>
        </tr>
    <?php endforeach; ?>     
</table>