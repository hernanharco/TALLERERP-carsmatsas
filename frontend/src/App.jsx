import { useState } from 'react'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100">
      <div className="container mx-auto px-4 py-16">
        <div className="max-w-4xl mx-auto">
          <div className="bg-white rounded-lg shadow-xl p-8">
            <h1 className="text-4xl font-bold text-gray-800 mb-4">
              TallerERP
            </h1>
            <p className="text-gray-600 mb-8">
              Sistema de gestión empresarial
            </p>
            
            <div className="flex items-center gap-4 mb-8">
              <button
                onClick={() => setCount(count - 1)}
                className="px-6 py-2 bg-red-500 text-white rounded-lg hover:bg-red-600 transition-colors"
              >
                -
              </button>
              <span className="text-2xl font-semibold text-gray-700">
                Contador: {count}
              </span>
              <button
                onClick={() => setCount(count + 1)}
                className="px-6 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition-colors"
              >
                +
              </button>
            </div>

            <div className="mt-8 p-4 bg-gray-50 rounded-lg">
              <p className="text-sm text-gray-600">
                Frontend: React + Vite + Tailwind CSS
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default App

