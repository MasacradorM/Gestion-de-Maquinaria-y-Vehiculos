import { defineConfig } from 'astro/config';
import react from '@astrojs/react';
import tailwind from '@astrojs/tailwind';
import path from 'path';
import { fileURLToPath } from 'url';
import sass from 'sass';

const __dirname = path.dirname(fileURLToPath(import.meta.url));

export default defineConfig({
  integrations: [
    react(),
    tailwind()
  ],
  
  vite: {
    resolve: {
      alias: {
        '@': path.join(__dirname, 'src'),
        '@components': path.join(__dirname, 'src/components'),
        '@layouts': path.join(__dirname, 'src/layouts'),
        '@pages': path.join(__dirname, 'src/pages'),
        '@styles': path.join(__dirname, 'src/styles'),
        '@utils': path.join(__dirname, 'src/utils'),
        '@types': path.join(__dirname, 'src/types'),
        '@assets': path.join(__dirname, 'src/assets')
      }
    },
    css: {
      preprocessorOptions: {
        scss: {
          implementation: sass,
          additionalData: `
            @use "src/styles/variables" as vars;
            @use "src/styles/mixins" as mix;
          `
        }
      }
    }
  },
  
  build: {
    assets: 'assets'
  }
});