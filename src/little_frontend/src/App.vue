<template>
  <div>
    <h1>{{ msg }}</h1>
  </div>
</template>

<script lang="js">
import { ref } from 'vue'

export default {
  name: "App",
  setup: function() {
    const msg = ref('');

    return {
      msg
    }
  },
  mounted: function() {
    fetch("/api/messages/hello", {
      method: "GET"
    }).then((response) => {
      return response.text();
    }).then((data) => {
      this.msg = data;
    })
  }
}
</script>